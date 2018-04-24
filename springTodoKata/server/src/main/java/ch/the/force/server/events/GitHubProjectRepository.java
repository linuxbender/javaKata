package ch.the.force.server.events;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GitHubProjectRepository extends PagingAndSortingRepository<GithubProject,Long> {
    GithubProject findByRepoName(String repoName);
}
