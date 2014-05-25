package com.dongsquad.smartstudy;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class SetChooserDialogFragment extends DialogFragment {

	public interface SetChooserDialogListener {
		void onSetChooserDialogPositiveClick(SetChooserDialogFragment dialog);
        void onSetChooserDialogNegativeClick(SetChooserDialogFragment dialog);
	}
	
	private SetChooserDialogListener mListener;
	
	// Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (SetChooserDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement SetChooserDialogListener");
        }
    }
	
    private SetBankSource source = null;
	private CharSequence[] items = { };
	private int mSelected = -1;
	
	public void setSource(SetBankSource source) {
		this.source = source;
	}
	
	public CharSequence getSelected() {
		if (mSelected >= 0) {
			return items[mSelected];
		} else {
			return null;
		}
	}
	
	public int getSelectedIndex() {
		return mSelected;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    
	    if (source != null) {
	    	List<TermSet> sets = source.getSet();
	    	if (!sets.isEmpty()) {
	    		items = new CharSequence[sets.size()];
	    		for (int i = 0; i < sets.size(); i++) {
	    			items[i] = sets.get(i).name;
	    		}
	    	}
	    }
	    
	    // Set the dialog title
	    builder.setTitle(R.string.set_chooser_dialog_title)
	    // Specify the list array, the items to be selected by default (null for none),
	    // and the listener through which to receive callbacks when items are selected
	           .setSingleChoiceItems(items, -1,
	                      new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int which) {
                	   mSelected = which;
	               }
	           })
	    // Set the action buttons
	           .setPositiveButton(R.string.set_chooser_dialog_ok, new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                   // User clicked OK, so save the mSelectedItems results somewhere
	                   // or return them to the component that opened the dialog
	                   mListener.onSetChooserDialogPositiveClick(SetChooserDialogFragment.this);
	               }
	           })
	           .setNegativeButton(R.string.set_chooser_dialog_cancel, new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                   mListener.onSetChooserDialogNegativeClick(SetChooserDialogFragment.this);
	               }
	           });

	    return builder.create();
	}
	
}
