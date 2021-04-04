package cats.form;

public class VoteForm {

    private long catWinnerId;
    private long profileId;
    private long catLoseId;

    public long getCatWinnerId() { return catWinnerId; }
    public void setCatWinnerId(long catWinnerId) { this.catWinnerId = catWinnerId; }

    public long getCatLoseId() { return catLoseId; }
    public void setCatLoseId(long catLoseId) { this.catLoseId = catLoseId; }

    public long getProfileId() { return profileId; }
    public void setProfileId(long profileId) { this.profileId = profileId; }
}
