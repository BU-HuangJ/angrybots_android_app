package adapters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.TreeMap;

import com.group3.angrybots.R;

import android.content.Context;

public class CodexReader {
	public static class Pair {
		public String title, description;
		public Pair(String title, String description) {
			this.title = title.trim();
			this.description = description.trim();
		}
	}
	private static TreeMap<Character, ArrayList<Pair>> codex = null;
	
	private static TreeMap<Character, ArrayList<Pair>> getCodex(Context context) {
		if (CodexReader.codex == null) {
			CodexReader.codex = CodexReader.populate(context);
		}
		return CodexReader.codex;
	}
	
	private static TreeMap<Character, ArrayList<Pair>> populate(Context context) {
		TreeMap<Character, ArrayList<Pair>> _codex = new TreeMap<Character, ArrayList<Pair>>();
		
		InputStream inputStream = context.getResources().openRawResource(R.raw.codex);
		InputStreamReader inputStreamReader;
		try {
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			inputStreamReader = new InputStreamReader(inputStream);
		}
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		try {
			while(bufferedReader.ready()) {
				String line = bufferedReader.readLine();
				if (!line.equals("")) {
					Pair pair;
					if (line.startsWith("Title: ")) {
						int start = line.indexOf(' ') + 1;
						String title = line.substring(start);
						line = bufferedReader.readLine();
						start = line.indexOf(' ') + 1;
						String description = line.substring(start);
						pair = new Pair(title, description);
					} else {
						String[] entry = line.split(":");
						pair = new Pair(entry[0], entry[1]);
					}
					Character letter = Character.toLowerCase(pair.title.charAt(0));
					ArrayList<Pair> pairs = _codex.get(letter);
					if (pairs != null) {
						pairs.add(pair);
					} else {
						pairs = new ArrayList<CodexReader.Pair>();
						pairs.add(pair);
						_codex.put(letter, pairs);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return _codex;
	}
	
	public static ArrayList<Pair> getEntries(Character c, Context context) {
		return CodexReader.getCodex(context).get(c);
	}

}
