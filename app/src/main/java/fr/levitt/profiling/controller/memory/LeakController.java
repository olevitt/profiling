package fr.levitt.profiling.controller.memory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memory")
public class LeakController {

	private List<String> REQUESTS_LOG = new ArrayList<String>();
	
	@PostMapping
	public void leak(@RequestBody String requestContent) {
		REQUESTS_LOG.add(requestContent);
	}
}
