package android.lee.sunshine.Fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.lee.sunshine.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class DetailFragment extends Fragment {

    private static final String LOG_TAG = DetailFragment.class.getSimpleName();
    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private String mForecastStr;

    public DetailFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
       mForecastStr = getActivity().getIntent().getStringExtra(Intent.EXTRA_TEXT);
       ((TextView)rootView.findViewById(R.id.detail_textview))
               .setText(mForecastStr);
       return rootView;
    }


   @Override
   public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
      inflater.inflate(R.menu.detailfragment, menu);

      MenuItem menuItem = menu.findItem(R.id.action_share);

      // Get the provider
      ShareActionProvider provider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

      // Attach an intent to this ShareActionProvider.
      if(provider != null)
         provider.setShareIntent(createShareForecastIntent());
      else{
         Log.d(LOG_TAG, "Share Action Provider is null.");
      }
   }

   private Intent createShareForecastIntent(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,
                mForecastStr + FORECAST_SHARE_HASHTAG);

        return shareIntent;
    }

}
