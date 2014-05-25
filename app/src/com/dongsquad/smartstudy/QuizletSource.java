package com.dongsquad.smartstudy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.dongsquad.smartstudy.json.JSONArray;

public class QuizletSource implements SetsSource {
	
	private LinkedList<TermSet> sets = new LinkedList<TermSet>();

	public int getSets(String username) throws IOException {
		String urlString = "https://api.quizlet.com/2.0/users/" + username + "/sets?client_id=PhAkDPKFu6&whitespace=1";
		URL url = new URL(urlString);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
		StringBuilder sb = new StringBuilder();
		int ch;
        while ((ch = in.read()) != -1)
            sb.append((char)ch);
        
        JSONArray setsJson = new JSONArray(sb.toString());
        
        sets.clear();
        
        for (int i = 0; i < setsJson.length(); i++) {
        	TermSet set = new TermSet(setsJson.getJSONObject(i));
        	sets.add(set);
        }
        
        return sets.size();
	}
	
	@Override
	public List<TermSet> getSets() {
		return sets;
	}

}
