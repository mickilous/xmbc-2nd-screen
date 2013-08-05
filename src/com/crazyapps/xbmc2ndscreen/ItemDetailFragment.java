package com.crazyapps.xbmc2ndscreen;

import java.io.InputStream;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crazyapps.xbmc2ndscreen.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen. This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity} on handsets.
 */
public class ItemDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment represents.
	 */
	public static final String		ARG_ITEM_ID	= "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem	mItem;

	private View					rootView;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation
	 * changes).
	 */
	public ItemDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			// ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.plot);
			new DownloadImageTask().execute(mItem.getFanart());
			((TextView) rootView.findViewById(R.id.item_plot)).setText(mItem.plot);
		}

		return rootView;
	}

	/**
	 * @param result
	 */
	private void setImageDrawable(Drawable result) {
		((ImageView) rootView.findViewById(R.id.item_fanart)).setImageDrawable(result);

	}

	private class DownloadImageTask extends AsyncTask<String, Integer, Drawable> {
		private Drawable loadImageFromNetwork(String url) {
			try {
				InputStream is = (InputStream) new URL(url).getContent();
				Drawable d = Drawable.createFromStream(is, "src name");
				return d;
			} catch (Exception e) {
				System.out.println("Exc=" + e);
				return null;
			}
		}

		protected Drawable doInBackground(String... urls) {
			return loadImageFromNetwork(urls[0]);
		}

		protected void onPostExecute(Drawable result) {
			setImageDrawable(result);
		}
	}
}
