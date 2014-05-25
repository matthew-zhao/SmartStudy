package com.dongsquad.smartstudy;

import android.app.Activity;
import android.app.DialogFragment;

public class CategoriesDialogFragment extends DialogFragment {
	
	public interface CategoriesDialogListener {
		void onDialogPositiveClick(CategoriesDialogFragment dialog);
        void onDialogNegativeClick(CategoriesDialogFragment dialog);
	}
	
	private CategoriesDialogListener mListener;

	// Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (CategoriesDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement FilterDialogListener");
        }
    }
	

}
