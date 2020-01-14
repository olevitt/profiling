package fr.levitt.profiling.controller.sql;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.levitt.profiling.data.ReverseHash;
import fr.levitt.profiling.data.ReverseHashRepository;
import fr.levitt.profiling.service.Bruteforce;
import fr.levitt.profiling.service.Hasher;

@RestController
@RequestMapping("/reverse")
public class ReverseHashController {

	@Autowired
	private ReverseHashRepository reverseHashRepository;

	@GetMapping
	public ReverseResult reverse(@RequestParam("data") String hash) {
		if (hash == null || hash.length() != 64) {
			throw new IllegalArgumentException("Invalid hash");
		}

		ReverseResult result = new ReverseResult();
		result.setHash(hash);

		String bruteforcedSource = Bruteforce.testRandomHashes(hash);
		
		if (bruteforcedSource != null) {
			result.setSource(bruteforcedSource);
			return result;
		}

		List<ReverseHash> foundHashs = reverseHashRepository.findByHash(hash);
		if (foundHashs.size() > 0) {
			result.setSource(foundHashs.get(0).getSource());
		}
		else {
			result.setSource("Not found");
		}
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
