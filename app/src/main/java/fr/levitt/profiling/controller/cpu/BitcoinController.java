package fr.levitt.profiling.controller.cpu;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.levitt.profiling.service.Hasher;

@RestController
@RequestMapping("/cpu")
public class BitcoinController {
	
	@PostMapping
	public Result mineBitcoin(@RequestBody String data) {
		String difficulty = "00000";
		Long nonce = 0L;
		
		while (true) {
			String dataToHash = 
					data + ":" +
                    String.valueOf(nonce);
			if (Hasher.applySha256(dataToHash) != null && Hasher.applySha256(dataToHash).substring(0, difficulty.length()).equals(difficulty)) {
				Result result = new Result();
				result.setData(dataToHash);
				result.setHash(Hasher.applySha256(dataToHash));
				return result;
			}
			nonce++;
		}
	}
	
	public static class Result {
		private String hash, data;

		public String getHash() {
			return hash;
		}

		public void setHash(String hash) {
			this.hash = hash;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
		
		
	}
}
