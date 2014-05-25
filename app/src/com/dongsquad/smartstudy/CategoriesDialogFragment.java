package com.dongsquad.smartstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class CategoriesDialogFragment extends DialogFragment {
	
	public interface CategoriesDialogListener {
		void onCategoriesDialogDoneClick(CategoriesDialogFragment dialog, ArrayList<CharSequence> selected);
        void onCategoriesDialogAddClick(CategoriesDialogFragment dialog);
	}
	
	private CategoriesDialogListener mListener;
	private ArrayList<Integer> mSelectedItems = new ArrayList<Integer>();

	private CharSequence[] items = { };
	public void setChoiceItems(CharSequence[] items) {
		this.items = items;
		isSelected = new boolean[items.length];
	}
	
	private boolean[] isSelected = { };
	public void setSelectedItems(Set<CharSequence> selectedItems) {
		for (int i = 0; i < items.length; i++) {
			if (selectedItems.contains(items[i]))
				this.isSelected[i] = true; 
		}
	}

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
                    + " must implement CategoriesDialogListener");
        }
    }
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mSelectedItems = new ArrayList<Integer>();  // Where we track the selected items
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title
        builder.setTitle(R.string.categories_dialog_title)
        // Specify the list array, the items to be selected by default (null for none),
        // and the listener through which to receive callbacks when items are selected
               .setMultiChoiceItems(items, isSelected,
                          new DialogInterface.OnMultiChoiceClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which,
                           boolean isChecked) {
                       if (isChecked) {
                           // If the user checked the item, add it to the selected items
                           mSelectedItems.add(which);
                       } else if (mSelectedItems.contains(which)) {
                           // Else, if the item is already in the array, remove it 
                           mSelectedItems.remove(Integer.valueOf(which));
                       }
                   }
               })
        // Set the action buttons
               .setPositiveButton(R.string.categories_dialog_done, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {
                       // User clicked OK, so save the mSelectedItems results somewhere
                       // or return them to the component that opened the dialog
                	   ArrayList<CharSequence> selected = new ArrayList<CharSequence>();
                	   for (Integer i : mSelectedItems)
                		   selected.add(items[i]);
                       mListener.onCategoriesDialogDoneClick(CategoriesDialogFragment.this, selected);
                   }
               })
               .setNegativeButton(R.string.categories_dialog_add, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {
                	   mListener.onCategoriesDialogAddClick(CategoriesDialogFragment.this);
                   }
               });

        return builder.create();
    }
	

}
