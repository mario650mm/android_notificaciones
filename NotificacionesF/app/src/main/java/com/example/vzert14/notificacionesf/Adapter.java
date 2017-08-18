package com.example.vzert14.notificacionesf;

import android.app.Activity;
import android.view.LayoutInflater;

import java.util.ArrayList;


public class Adapter  {
//public class Adapter extends ArrayAdapter<Notification> {

    private Activity mActivity;

    private ArrayList<Notification> car;
    private static LayoutInflater inflater = null;



    /*public Adapter(Activity activity, int textViewResourceid, ArrayList<Notification> list) {
        //super(activity, textViewResourceid, list);
        try {
            this.mActivity = activity;
            car = list;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {
        }

    }

    public  int getCount(){return car.size();}

    public Notification getItem(Notification position){return  position;}

    public long getItemId(int position){return position;}

    public static class ViewHolder {
        public TextView display_name;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        final ViewHolder holder;
        try{
            if (convertView == null){
                vi = inflater.inflate(R.layout.activity_main, null);
                holder = new ViewHolder();

                holder.display_name = (TextView) vi.findViewById(R.id.label);

                vi.setTag(holder);

            }else{
                holder = (ViewHolder) vi.getTag();
            }
            holder.display_name.setText(mActivity.getString(R.string.coords,String.valueOf(car.get(position).getLat()),String.valueOf(car.get(position).getLon())));

        }catch (Exception e){

        }

        return vi;
    }*/
}

