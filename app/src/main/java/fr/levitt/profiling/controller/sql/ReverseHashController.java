package fr.levitt.profiling.controller.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.levitt.profiling.data.ReverseHash;
import fr.levitt.profiling.data.ReverseHashRepository;

@RestController
@RequestMapping("/sql")
public class ReverseHashController {
	
	@Autowired
	private ReverseHashRepository reverseHashRepository;

	@GetMapping
	public ReverseResult reverse(@RequestParam("data") String hash) {
		System.out.println("Recherche dans une base de "+reverseHashRepository.count()+ " éléments");
		ReverseResult result = new ReverseResult();
		result.setHash(hash);
		List<ReverseHash> foundHashs = reverseHashRepository.findByHash(hash);
		if (foundHashs.size() > 0) {
			for (ReverseHash reverseHash : foundHashs) {
				System.out.println(reverseHash.getSource());
			}
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
