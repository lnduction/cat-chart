package cats.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class CatsFilter extends cats.filter.AbstractFilter {

	@Value("${application.production}")
	private boolean production;
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		String requestUrl = req.getRequestURI();
		req.setAttribute("REQUEST_URL", requestUrl);
		try {
			chain.doFilter(req, resp);
		} catch (Throwable th) {
			LOGGER.error("Process request failed: " + requestUrl, th);
			handleException(th, requestUrl, resp);
		}
	}
	
	private void handleException(Throwable th, String requestUrl, HttpServletResponse resp) throws ServletException, IOException {
		if(production) {
			if ("/error".equals(requestUrl)) {
				sendErrorStatus(resp);
			} else {
				resp.sendRedirect("/error?url="+requestUrl);
			}
		} else {
			throw new ServletException(th);
		}
	}

	private void sendErrorStatus(HttpServletResponse resp) throws IOException {
		resp.reset();
		resp.getWriter().write("");
		resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}
}
