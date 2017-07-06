package demo.model;

import java.util.ArrayList;
import java.util.List;
import demo.entities.Language;

public class LanguageModel {

	public List<Language> findAll() {
		List<Language> languages = new ArrayList<Language>();
		languages.add(new Language("l1", "Language 1"));
		languages.add(new Language("l2", "Language 2"));
		languages.add(new Language("l3", "Language 3"));
		languages.add(new Language("l4", "Language 4"));
		languages.add(new Language("l5", "Language 5"));
		return languages;
	}
	
}
