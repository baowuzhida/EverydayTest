package _HaiTong.Y19_4_16.DDQ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataIterator implements Iterator {
    private List<Integer> list;
    private int position;

    public DataIterator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (position > list.size())
            return false;
        else
            return true;
    }

    @Override
    public Object next() {
        return list.get(position++);
    }
}
