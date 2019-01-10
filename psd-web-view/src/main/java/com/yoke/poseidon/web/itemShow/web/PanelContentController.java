package com.yoke.poseidon.web.itemShow.web;

import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@RestController
@RequestMapping("/panelContent")
public class PanelContentController {

	@GetMapping("/pets/{petId}")
	public void findPet(@PathVariable String petId, @MatrixVariable int q) {
		System.out.println(q);
		System.out.println(petId);
		// petId == 42
		// q == 11
	}

}
