package fr.levitt.profiling.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReverseHashRepository extends CrudRepository<ReverseHash, Long> {

	List<ReverseHash> findByHash(String hash);
}
