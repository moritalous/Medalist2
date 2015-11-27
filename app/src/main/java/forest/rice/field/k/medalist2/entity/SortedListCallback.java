package forest.rice.field.k.medalist2.entity;

import android.support.v7.util.SortedList;

public class SortedListCallback extends SortedList.Callback<MedalEntity> {

    @Override
    public int compare(MedalEntity o1, MedalEntity o2) {

        int i1 = 0;
        int i2 = 1;
        try {
            i1 = Integer.parseInt(o1.phase);
            i2 = Integer.parseInt(o2.phase);
        } catch (Exception e) {

        }

        return i1 - i2;
    }

    @Override
    public void onInserted(int position, int count) {

    }

    @Override
    public void onRemoved(int position, int count) {

    }

    @Override
    public void onMoved(int fromPosition, int toPosition) {

    }

    @Override
    public void onChanged(int position, int count) {

    }

    @Override
    public boolean areContentsTheSame(MedalEntity oldItem, MedalEntity newItem) {
        return oldItem.phase.equals(newItem.phase) && oldItem.id.equals(newItem.id);
    }

    @Override
    public boolean areItemsTheSame(MedalEntity item1, MedalEntity item2) {
        return item1.phase.equals(item2.phase) && item1.id.equals(item2.id);
    }
}
