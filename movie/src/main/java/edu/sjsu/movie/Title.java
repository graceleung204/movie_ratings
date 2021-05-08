package edu.sjsu.movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
/*
	tconst (string) - alphanumeric unique identifier of the title
	titleType (string) – the type/format of the title (e.g. movie, short, tvseries, tvepisode, video, etc)
	primaryTitle (string) – the more popular title / the title used by the filmmakers on promotional materials at the point of release
	originalTitle (string) - original title, in the original language
	isAdult (boolean) - 0: non-adult title; 1: adult title
	startYear (YYYY) – represents the release year of a title. In the case of TV Series, it is the series start year
	endYear (YYYY) – TV Series end year. ‘\N’ for all other title types
	runtimeMinutes – primary runtime of the title, in minutes
	genres(string array)–includes up to three genres associated with the title
*/

@Data
// @NoArgsConstructor  // required by Hibernate for Entity creation?
@RequiredArgsConstructor
@Entity
@Table()
public class Title {
	
    private @Id long id;  //tconst
	private String titleType;
	private String primaryTitle;
	private String originalTitle;
	private boolean isAdult;
	private int startYear;
	private int endYear;
	private int runtimeMinutes;
	private String[] genres;
	
}
