package com.geek.listcontacts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.geek.listcontacts.model.ContactModel;
import com.geek.listcontacts.ui.MainAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.IListener {
    private final List<ContactModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addContacts();
        init();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MainAdapter adapter = new MainAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    @Override
    public void onItemClick(String number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_baseline_contact_phone_24)
                .setTitle("Phone number")
                .setMessage(number)
                .setPositiveButton("Call", (dialog, which) -> {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+number));
                    startActivity(intent);
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
    AlertDialog alertDialog = builder.create();
    alertDialog.show();
    }


    private void addContacts() {
        list.add(new ContactModel("Billie","0777-77-77-77"));
        list.add(new ContactModel("Lisa","0777-11-11-11"));
        list.add(new ContactModel("Mona","0777-22-22-22"));
        list.add(new ContactModel("Billie","0777-33-33-33"));
        list.add(new ContactModel("Lisa","0777-74-74-74"));
        list.add(new ContactModel("Mona","0777-75-76-77"));
        list.add(new ContactModel("Billie","0777-77-77-79"));
        list.add(new ContactModel("Lisa","0777-57-57-57"));
        list.add(new ContactModel("Mona","0777-86-11-77"));
        list.add(new ContactModel("Lisa","0777-67-77-00"));
    }
}