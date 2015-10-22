package com.example.harrisonj2.andriodtraining;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by harrisonj2 on 10/22/2015.
 */
public class PeopleResultsAdapter extends ArrayAdapter<Person> {
    Person person;
    TextView nameTextView;
    TextView emailTextView;

    public PeopleResultsAdapter(Context context, Person[] objects) {
        super(context, R.layout.custom_row, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View peopleView = inflater.inflate(R.layout.custom_row, parent, false);

        person = getItem(position);
        nameTextView = (TextView) peopleView.findViewById((R.id.nameTextView));
        emailTextView = (TextView) peopleView.findViewById((R.id.emailTextView));

        nameTextView.setText(person.getName());
        emailTextView.setText(person.getEmail());

        return peopleView;
    }


}
