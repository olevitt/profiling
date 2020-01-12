package fr.levitt.profiling.controller.memory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.levitt.profiling.service.Hasher;

@RestController
@RequestMapping("/memory")
public class LeakController {

	private List<String> REQUESTS_LOG = new ArrayList<String>();
	
	@PostMapping
	public Hash leak(@RequestBody String requestContent) {
		REQUESTS_LOG.add(requestContent);
		String result = Hasher.applySha256(requestContent);
		return new Hash(result);
	}
	
	public static class Hash {
		private String hash;
		
		public Hash(String hash) {
			this.hash = hash;
		}

		public String getHash() {
			return hash;
		}

		public void setHash(String hash) {
			this.hash = hash;
		}
		
		
	}
}
