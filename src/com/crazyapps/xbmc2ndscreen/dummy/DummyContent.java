package com.crazyapps.xbmc2ndscreen.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

/**
 * Helper class for providing sample content for user interfaces created by Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DummyItem>			ITEMS		= new ArrayList<DummyItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DummyItem>	ITEM_MAP	= new HashMap<String, DummyItem>();

	static {
		// Add 3 sample items.
		addItem(new DummyItem("1", "Item 1"));
		addItem(new DummyItem("2", "Item 2"));
		addItem(new DummyItem("3", "Item 3"));

		DummyItem di = new DummyItem("It");
		di.setFanart("http://cf2.imgobject.com/t/p/original/gQ23EIbgY1OWGzRond6BLOg6U9E.jpg");
		di.setGenre("Drama, Horror");
		di.setPlot("A series of murders prompts Mike Hanlon to suspect that the supernatural menace that he and a group of friends battled as children has returned. He begins to call his friends to remind them of the oath they swore: if It returned again, they would come back to Derry to do battle again.");
		di.setRating(7.3000001907348633);
		di.setThumbnail("http://cf2.imgobject.com/t/p/original/p2Aw1uTy9SmdXXhO4WQxeG9FUrU.jpg");
		di.setYear(1990);

		JSONObject jo = new JSONObject();
		addItem(di);
	}

	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.title, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {

		public String	title;
		public String	plot;
		public String	genre;
		public Integer	year;
		public Double	rating;
		public String	fanart;
		public String	thumbnail;

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the plot
		 */
		public String getPlot() {
			return plot;
		}

		/**
		 * @param plot
		 *            the plot to set
		 */
		public void setPlot(String plot) {
			this.plot = plot;
		}

		/**
		 * @return the genre
		 */
		public String getGenre() {
			return genre;
		}

		/**
		 * @param genre
		 *            the genre to set
		 */
		public void setGenre(String genre) {
			this.genre = genre;
		}

		/**
		 * @return the year
		 */
		public Integer getYear() {
			return year;
		}

		/**
		 * @param year
		 *            the year to set
		 */
		public void setYear(int year) {
			this.year = year;
		}

		/**
		 * @return the rating
		 */
		public Double getRating() {
			return rating;
		}

		/**
		 * @param rating
		 *            the rating to set
		 */
		public void setRating(Double rating) {
			this.rating = rating;
		}

		/**
		 * @return the fanart
		 */
		public String getFanart() {
			return fanart;
		}

		/**
		 * @param fanart
		 *            the fanart to set
		 */
		public void setFanart(String fanart) {
			this.fanart = fanart;
		}

		/**
		 * @return the thumbnail
		 */
		public String getThumbnail() {
			return thumbnail;
		}

		/**
		 * @param thumbnail
		 *            the thumbnail to set
		 */
		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}

		public DummyItem(String title, String plot) {
			this.title = title;
			this.plot = plot;
		}

		public DummyItem(String title) {
			this.title = title;
		}

		@Override
		public String toString() {
			return title;
		}
	}
}
