package fr.levitt.profiling.controller.sql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql")
public class ReverseHashController {

	@GetMapping
	public ReverseResult reverse() {
		ReverseResult result = new ReverseResult();
		result.setSource("WIPP");
		result.setHash("WIP");
		return result;
	}
	
	public static class ReverseResult {
		
		private String source, hash;

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getHash() {
			return hash;
		}

		public void setHash(String hash) {
			this.hash = hash;
		}
		
		
	}
	
}
