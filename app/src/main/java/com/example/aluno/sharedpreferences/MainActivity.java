package com.example.aluno.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btSalvar) {
            Toast.makeText(this,"Dados foram salvos com sucesso!",
                    Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor;
            SharedPreferences sp;
            sp = getSharedPreferences("teste", 0);
            editor = sp.edit();
            editor.putString("nome",((EditText) findViewById(R.id.editTextNome)).getText().toString());
            editor.putString("tel",((EditText) findViewById(R.id.editTextTel)).getText().toString());
            editor.putString("email",((EditText) findViewById(R.id.editTextEmail)).getText().toString());
            editor.putString("cpf",((EditText) findViewById(R.id.editTextCPF)).getText().toString());
            editor.putString("endereco",((EditText) findViewById(R.id.editTextEndereco)).getText().toString());
            editor.commit();

            ((EditText)findViewById(R.id.editTextNome)).setText("");
            ((EditText)findViewById(R.id.editTextTel)).setText("");
            ((EditText)findViewById(R.id.editTextEmail)).setText("");
            ((EditText)findViewById(R.id.editTextCPF)).setText("");
            ((EditText)findViewById(R.id.editTextEndereco)).setText("");

            return true;
        }else if (id == R.id.btLer) {
            Toast.makeText(this,"Dados foram lidos com sucesso!",
                    Toast.LENGTH_SHORT).show();

            SharedPreferences sp;
            sp = getSharedPreferences("teste", 0);

            ((EditText) findViewById(R.id.editTextNome)).setText(sp.getString("nome",null));
            ((EditText) findViewById(R.id.editTextTel)).setText(sp.getString("tel",null));
            ((EditText) findViewById(R.id.editTextEmail)).setText(sp.getString("email",null));
            ((EditText) findViewById(R.id.editTextCPF)).setText(sp.getString("cpf",null));
            ((EditText) findViewById(R.id.editTextEndereco)).setText(sp.getString("endereco",null));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

