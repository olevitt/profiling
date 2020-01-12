package fr.levitt.profiling.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.levitt.profiling.service.Hasher;

@Configuration
public class InitData {
	
	@Autowired
	private ReverseHashRepository reverseHashRepository;

	@Bean
	InitializingBean fillDatabase() {
		return () -> {
		//	new Thread(() -> {
				List<ReverseHash> entities = new ArrayList<>();
				for (int i = 0; i < 100000; i++) {
					ReverseHash hash = new ReverseHash();
					String source = ""+i;
					hash.setSource(source);
					hash.setHash(Hasher.applySha256(source));
					entities.add(hash);
				}
				System.out.println("Insert "+entities.size());
				reverseHashRepository.saveAll(entities);
				System.out.println("Chargement terminé");
				System.out.println("Nombre de hashs en base "+reverseHashRepository.count());
			//}).start();
			
		};
	}
}
