package xyz.zohre.presentation_shared.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import xyz.zohre.presentation_shared.R;

public class ProgressBarViewHolder extends BaseViewHolder {

    private Object o;

    private ProgressBarViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public static ProgressBarViewHolder newInstance(ViewGroup viewGroup) {
        return new ProgressBarViewHolder(getView(viewGroup, R.layout.layout_progress));
    }

    @Override
    public void bind(@NonNull Object o) {
        this.o = o;
    }
}
