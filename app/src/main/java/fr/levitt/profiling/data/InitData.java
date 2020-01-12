package fr.levitt.profiling.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.levitt.profiling.service.Hasher;

@Configuration
public class InitData {

	@Value("${fr.levitt.profiling.hashdbsize}")
	private int dbSize;
	
	@Autowired
	private ReverseHashRepository reverseHashRepository;

	@Bean
	InitializingBean fillDatabase() {
		return () -> {
			new Thread(() -> {
				int nbIteration = dbSize;
				int taillePaquet = 100000;
				for (int iteration = 0; iteration < nbIteration; iteration++) {
					List<ReverseHash> entities = new ArrayList<>();
					for (int i = iteration * taillePaquet; i < (iteration +1) * taillePaquet; i++) {
						ReverseHash hash = new ReverseHash();
						String source = ""+i;
						hash.setSource(source);
						hash.setHash(Hasher.applySha256(source));
						entities.add(hash);
					}
					reverseHashRepository.saveAll(entities);
					System.out.println("[Data injection] "+iteration);
				}
				
			}).start();

		};
	}
}
