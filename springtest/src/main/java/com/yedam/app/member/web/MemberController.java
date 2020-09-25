package com.yedam.app.member.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.member.MemberVo;
import com.yedam.app.member.service.MemberService;

@Controller
public class MemberController {
	
	
	@Autowired  //==getBean("memberDAO") == new MemberDAO()
	MemberService memberService;
	
	/*
	 * public ArrayList<MemberVo> memberListAjax() { //회원조회 return
	 * memberService.selectAll(null); }
	 */
	@RequestMapping("/memberListAjax")
	@ResponseBody //json string 변환
	public List<MemberVo> memberListAjax() {
		//회원조회
		return memberService.selectAll();
	}
	
	@RequestMapping("/memberOneAjax")
	@ResponseBody //json string 변환
	public MemberVo memberOneAjax(MemberVo memberVo) {
		return memberService.selectOne(memberVo);
	}
	
	
	
	
	
	@RequestMapping("/memberList")
	public String memberList(Model model, 
							HttpServletRequest request, 
							HttpSession session) {

		//회원조회
		model.addAttribute("list", memberService.selectAll());
		
		return "/member/memberAll";
		
	}
	
	//등록페이지
	@RequestMapping(value = "/memberInsert", method=RequestMethod.GET)
	public String memberInsertForm() {
		return "member/memberInsert";
	}
	
	
	
	//등록처리
	@RequestMapping(value = "/memberInsert", method=RequestMethod.POST)
	public String memberInsert(MemberVo vo) {
		memberService.insert(vo);
		return "redirect:/memberList";
	
	}
	
	
	//단건조회
	/*
	 * @RequestMapping(value = "/memberSelect") public String memberSelect(MemberVo
	 * vo, Model model) { model.addAttribute("member", memberService.selectOne(vo));
	 * return "member/memberSelect"; }
	 */
	@RequestMapping(value = "/memberSelect")
	public String memberSelect(@RequestParam(name = "id", required = false, defaultValue = "uuuu")  String mid,
								Model model,
								HttpServletRequest request) {
		//String mid = request.getParameter("id"); =>@RequestParam(name = "id")  String mid 랑 같은 말.
		//if(id != null) {
		//	mid = "uuuu";
		//}  ==> required = false, defaultValue = "uuuu" 랑 같은 말.
		MemberVo vo = new MemberVo();
		vo.setId(mid);
		model.addAttribute("member", memberService.selectOne(vo));
		return "member/memberSelect";
	}
	
	
	// 경로명에 변수가 포함(@PathVariable - 슬래시하고 변수넣어서)
	@RequestMapping("/userSelectPath/{id}")
	public String userSelectPath(Model model, @PathVariable String id) {
		MemberVo vo = new MemberVo();
		vo.setId(id);
		model.addAttribute("member", memberService.selectOne(vo));
		return "member/memberSelect";
	}
	
	//파라미터를 map에
	@RequestMapping("/userSelectMap")
	public String userSelectMap(@RequestParam Map map) {
		System.out.println(map);
		return "";
	}
}
