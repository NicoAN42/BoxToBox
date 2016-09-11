package id.sch.smktelkom_mlg.tugas01.xirpl2019.boxtobox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNamaPengirim;
    TextView tvhasil, tvhasil2, tvhasil3, tvhasil4;
    Button bok, bv;
    RadioButton rbPn, rbPo;
    Spinner spbarang;
    CheckBox kp, kb, id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbPn = (RadioButton) findViewById(R.id.perusahaan);
        rbPo = (RadioButton) findViewById(R.id.perorangan);
        kp = (CheckBox) findViewById(R.id.kp);
        kb = (CheckBox) findViewById(R.id.kb);
        id = (CheckBox) findViewById(R.id.id);
        bv = (Button) findViewById(R.id.validasi);
        etNamaPengirim = (EditText) findViewById(R.id.namapengirim);
        tvhasil = (TextView) findViewById(R.id.hasil);
        bok = (Button) findViewById(R.id.ok);
        tvhasil2 = (TextView) findViewById(R.id.hasil2);
        tvhasil3 = (TextView) findViewById(R.id.hasil3);
        spbarang = (Spinner) findViewById(R.id.barang);
        tvhasil4 = (TextView) findViewById(R.id.hasil4);

        bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick2();
            }
        });

        bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();
                doClick();

            }
        });

    }

    private void doClick2() {
        String hasil4="VALIDASI :\n ";
        int startln = hasil4.length();

        if(kp.isChecked()) hasil4+=kp.getText()+"(√) ";
        if(kb.isChecked()) hasil4+=kb.getText()+"(√) ";
        if(id.isChecked()) hasil4+=id.getText()+"(√)";


        if(hasil4.length()==startln) hasil4+="GAGAL  (X)";
        tvhasil4.setText(hasil4);
    }

    private void doClick() {
        String hasil2 = null;
        if(rbPn.isChecked())
        {
            hasil2 = rbPn.getText().toString();
        }
        else if(rbPo.isChecked())
        {
            hasil2 = rbPo.getText().toString();
        }
        if (hasil2 == null)
        {
            tvhasil2.setText("Konten Belum Teriidentifikasi");
        }
        else {
            tvhasil2.setText("Kriteria Anda : " + hasil2);
        }

        tvhasil3.setText("Kriteria Barang : "+ spbarang.getSelectedItem().toString());


    }


    private void doProcess() {
        if(isValid())
        {
        String nama = etNamaPengirim.getText().toString();
        tvhasil.setText("Identitas Anda : " + nama);
    }
}

    private boolean isValid() {
        boolean valid = true;
        String nama = etNamaPengirim.getText().toString();

        if(nama.isEmpty())
        {
            etNamaPengirim.setError("Nama Belum diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNamaPengirim.setError("Nama Minimal 3 Karakter");
            valid = false;
        }
        else
        {
            etNamaPengirim.setError(null);
        }
        return valid;
    }
    }
