package edu.sjsu.movie;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
/*
	tconst (string) - alphanumeric unique identifier of the title
	directors (array of nconsts) - director(s) of the given title
	writers (array of nconsts) – writer(s) of the given title
*/

@Data
// @NoArgsConstructor // required by Hibernate for Entity creation?
@RequiredArgsConstructor
// @Entity
// @Table()
public class Crew {

	// private @Id String id;
	private String tconst;
	private String directors;
	private String writers;
}
