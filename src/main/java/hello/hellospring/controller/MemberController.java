package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/***
 *스프링 컨테이너가 ( 스프링 처음에 뜰때 ) @Controller 어노테이션이
 * 있으면 컨트롤러를 생성해서 스프링 컨테이너에 넣어놓고 관리를 한다.
  */
@Controller
public class MemberController {

    /***
     * 스프링이 관리를 하게 되면 스프링컨테이너에 등록을하고 받아서 쓰도록 바꿔야한다.
     * 예를 들어 MemberSerivce가 MemberController에서만 쓸수도 있지만 다른곳에서도 불러서 사용할수도있다.
     * 여러번 new로 MemberService를 생성할 필요 없이 스프링컨테이너에 등록하고 가져다 쓰면 된다.
     *
     * private final MemberService memberService = new MemberService();
      */

    private final MemberService memberService;

    /***
     * 스프링이 올라올때 @Controller가 있으면 해당 컨트롤러를 생성한다
     * 컨트롤러를 생성할때 아래 생성자를 호출하면서 @Autowired라는 어노테이션이 있으면
     * 스프링 컨테이너에 있는 MemberService를 가져와 연결을 시켜준다.
     * DI dependency injection
     */
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }



}
