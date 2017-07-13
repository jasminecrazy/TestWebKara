package demo.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.entity.Vn;
import demo.service.SongService;


@Controller
@RequestMapping("demo")
public class DemoController {
	@Autowired
	private SongService songService;
	@RequestMapping(method=RequestMethod.GET)
public String index()
{
	return "demo/index";
}
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public String detail()
	{
		return "demo/detail";
	}
	@RequestMapping(value = "detail/{id}", 
			method = RequestMethod.GET)
	public String detail(
		@PathVariable("id") int id, 
		ModelMap modelMap) {
		modelMap.put("songDetail",songService.getSongVol(id));
		return "demo/detail";
	}
	@RequestMapping(value="process",method = RequestMethod.GET)
	@ResponseBody
	public List<Vn> search(HttpServletRequest request)
	{
		String keyword= request.getParameter("term");
		return songService.searchSong(keyword);
	}
	@RequestMapping(value="detailSong/{id}",method= RequestMethod.GET)
	public String detailSong(@PathVariable("id") int id,ModelMap modelMap)
	{
		modelMap.put("detailSong", songService.getSong(id));
		return "demo/detailSong";
	}
	@RequestMapping(value="karaoke",method=RequestMethod.GET)
	public String kara()
	{
		return "demo/karaoke";
	}
	@RequestMapping(value = "albumdetail/{id}", 
			method = RequestMethod.GET)
	public String Songdetail(
		@PathVariable("id") int id, 
		ModelMap modelMap) {
		modelMap.put("albumDetail",songService.getAlbumSong(id));
		return "demo/albumdetail";
	}
	
	
	
	
}
