package cats.controller;

import cats.entity.Cat;
import cats.entity.Profile;
import cats.form.SingInForm;
import cats.form.SingUpForm;
import cats.service.FindCatService;
import cats.service.ProfileService;
import cats.service.VoteService;
import cats.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CatsController {

    @Autowired private FindCatService findCatService;
    @Autowired private ProfileService profileService;
    @Autowired private VoteService voteService;

    CatsController(){}

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String getWelcome(Model model){
        if (SecurityUtil.getCurrentProfileId() == -1) {
            addSuccess(model);
            return "welcome";
        }
        addSuccess(model);
        return "begin-vote";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String postWelcome(@Valid @ModelAttribute("singInForm") SingInForm form, BindingResult bindingResult, Model model) {
        Profile profile = profileService.findProfileByNameAndPassword(form.getItem().getName(), form.getItem().getPassword());
        if (profile == null) {
            ObjectError error = new ObjectError("item.password","InvalidEnter");
            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("singInForm", form);
            addSuccess(model);
            return "welcome";
        }
        SecurityUtil.setCurrentProfile(
                profileService.findProfileByNameAndPassword(
                        form.getItem().getName(),
                        form.getItem().getPassword()));
        return "redirect:/begin-vote";
    }

    private void addSuccess(Model model) {
        if (SecurityUtil.getCurrentProfileId() != -1) {
            model.addAttribute("success", true);
            model.addAttribute("profileName", SecurityUtil.getCurrentProfileName());
        } else model.addAttribute("success", false);
    }

    @RequestMapping(value = "/sing-up", method = RequestMethod.GET)
    public String getSingUp(){
        if (SecurityUtil.getCurrentProfileId() != -1) return "redirect:/begin-vote";
        return "sing-up";
    }

    @RequestMapping(value = "/sing-up", method = RequestMethod.POST)
    public String postSingUp(@Valid @ModelAttribute("singUpForm") SingUpForm form, BindingResult bindingResult, Model model){
        if (profileService.nameIsTaken(form.getName())) {
            ObjectError error = new ObjectError("name","NameIsTaken");
            bindingResult.addError(error);
        }
        if (!form.isFieldMatch()) {
            ObjectError error = new ObjectError("confirmPassword","FieldsNotMuch");
            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("singUpForm", form);
            addSuccess(model);
            return "sing-up";
        }
        profileService.createProfile(form);
        return "redirect:/sing-up/success";
    }

    @RequestMapping(value = "/sing-up/success", method = RequestMethod.GET)
    public String getSingUpSuccess(Model model){
        addSuccess(model);
        return "sing-up-success";
    }

    @RequestMapping(value = "/begin-vote", method = RequestMethod.GET)
    public String getBeginVote(Model model){
        if (SecurityUtil.getCurrentProfileId() == -1) return "redirect:/welcome";
        addSuccess(model);
        return "begin-vote";
    }

    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public String getVote(Model model){
        if (SecurityUtil.getCurrentProfileId() == -1) return "redirect:/welcome";
        return gotoVote(model);
    }

    private String gotoVote(Model model) {
        List<Cat> cats = findCatService.findTwoCat(SecurityUtil.getCurrentProfileId());
        if(cats.size() < 2) return "redirect:/top-list";
        model.addAttribute("firstCat", cats.get(0));
        model.addAttribute("secondCat", cats.get(1));
        addSuccess(model);
        return "vote";
    }

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public String postVote(@RequestParam(value="win") long winner,@RequestParam(value="lose") long lose, Model model){
        voteService.vote(SecurityUtil.getCurrentProfile(), winner, true);
        voteService.vote(SecurityUtil.getCurrentProfile(), lose, false);
        return gotoVote(model);
    }

    @RequestMapping(value = "/top-list", method = RequestMethod.GET)
    public String getTopList(Model model){
        if (SecurityUtil.getCurrentProfileId() == -1) return "redirect:/welcome";
        model.addAttribute("topCat", findCatService.findTopCat());
        addSuccess(model);
        return "top-list";
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String getExit(){
        SecurityUtil.setCurrentProfile(new Profile((long)-1));
        return "redirect:/welcome";
    }
}
