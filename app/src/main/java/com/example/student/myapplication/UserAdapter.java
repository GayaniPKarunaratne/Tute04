package com.example.student.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.myapplication.R;

import java.util.ArrayList;

import Model.Users;

 class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<Users> users;


     @Override
     public UserViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
         View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.recycle_layout , viewGroup , false);
         return new UserViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {

         Users user = users.get(i);

         userViewHolder.text1.setText( user.getUname() );
         userViewHolder.text2.setText( user.getPassword() );
         Log.i("DB" , "Called" );
     }

     @Override
     public int getItemCount() {
         return 0;
     }

     public class UserViewHolder extends RecyclerView.ViewHolder{

        TextView text1, text2;

        UserViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.username);
            text2 = (TextView) itemView.findViewById(R.id.password);
        }

    }

     @Override
     public void onAttachedToRecyclerView(RecyclerView recyclerView) {
         super.onAttachedToRecyclerView(recyclerView);
     }

    public UserAdapter(ArrayList<Users> users) {
        this.users = users;
    }





}


//     @Override
//     public UserViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
//
//
//     }

//     @Override
//     public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
//
//     }

//     @Override
//     public int getItemCount() {
//         return 0;
//     }


