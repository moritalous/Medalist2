package forest.rice.field.k.medalist2.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import forest.rice.field.k.medalist2.R;

public class MainContentViewHolder extends RecyclerView.ViewHolder {

    public static final int LAYOUT_ID = R.layout.main_content_row;

    public TextView name;
    public ImageView medalImage;

    public MainContentViewHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name);
        medalImage = (ImageView) itemView.findViewById(R.id.medal_image);
    }
}
