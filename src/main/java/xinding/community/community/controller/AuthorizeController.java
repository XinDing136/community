package xinding.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xinding.community.community.dto.AccessTokenDTO;
import xinding.community.community.provider.GithubProvider;

/**
 *哈哈哈
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("Iv1.506b688f12bfc606");
        accessTokenDTO.setClient_secret("c16f454debc266b39d5558dd855cc8cdae77e39c");
        githubProvider.getAccessToken(accessTokenDTO);

        return "index";
    }

}
