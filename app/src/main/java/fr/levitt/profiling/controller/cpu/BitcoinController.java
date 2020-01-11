package fr.levitt.profiling.controller.cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.levitt.profiling.service.Hasher;

@RestController
@RequestMapping("/cpu")
public class BitcoinController {

	@Autowired
    private Hasher hasher;
	
	@GetMapping
	public Result mineBitcoin() {
		String data = "Let's mine this";
		Long timestamp = System.currentTimeMillis();
		Long nonce = 0L;
		String difficulty = "00000";
		while (true) {
			String dataToHash = 
					data + ":" +
                    String.valueOf(timestamp) + ":" +
                    String.valueOf(nonce);
			String newHash = hasher.calculateHash(dataToHash);
			if (newHash.substring(0, difficulty.length()).equals(difficulty)) {
				Result result = new Result();
				result.setData(dataToHash);
				result.setHash(newHash);
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
