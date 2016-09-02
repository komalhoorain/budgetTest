package Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.test1.Listing;
import com.example.test.test1.MainActivity;
import com.example.test.test1.R;

import java.util.List;

import Model.CountryModel;

/**
 * Created by Komal UETian on 8/27/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<CountryModel> countary_list;
    private Listing obj;
    private Context cntxt;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,code;
        public  MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.countary_name);
            code = (TextView) view.findViewById(R.id.countary_code);
        }
    }
    public MyAdapter(List<CountryModel> countary_list, Listing obj , Context cntxt) {
        this.countary_list = countary_list;
        this.obj=obj;
        this.cntxt=cntxt;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final CountryModel countary = countary_list.get(position);
        holder.name.setText(countary.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cntxt, MainActivity.class);
                obj.startActivity(intent);
            }
        });
        holder.code.setText(countary.getCode());
        holder.code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return countary_list.size();
    }

}

