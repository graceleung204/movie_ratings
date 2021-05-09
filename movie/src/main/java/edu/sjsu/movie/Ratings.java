package edu.sjsu.movie;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
/*
	tconst (string) - alphanumeric unique identifier of the title
	averageRating – weighted average of all the individual user ratings
	numVotes - number of votes the title has received
*/

@Data
// @NoArgsConstructor  // required by Hibernate for Entity creation?
@RequiredArgsConstructor
// @Entity
// @Table()
public class Ratings {

    // private @Id String id;
    private String tconst;
	private double averageRating;
	private int	numVotes;
}
