package com.example.leechaelin.fourthweek;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button)findViewById(R.id.button1);
        b2= (Button)findViewById(R.id.button2);
        b3= (Button)findViewById(R.id.button3);
        b4= (Button)findViewById(R.id.button4);
        b5= (Button)findViewById(R.id.button5);
        b6= (Button)findViewById(R.id.button6);
        b7= (Button)findViewById(R.id.button7);
        b8= (Button)findViewById(R.id.button8);


        init();
        second();
        third();

    }
    void init(){
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"일반 메세지 창입니다 ",Toast.LENGTH_SHORT).show();
            }
        });
    }

    void second(){
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastView = Toast.makeText(getApplicationContext(),"위치 지정 메세지 창입니다 ",Toast.LENGTH_SHORT);

                toastView.setGravity(Gravity.CENTER|Gravity.TOP,10,20);
                toastView.show();
            }
        });
    }

    void third(){
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(getApplicationContext(),R.layout.activity_my_toast,null);


                TextView mes = (TextView)view.findViewById(R.id.textView);
                mes.setText("레이아웃으로 만든 토스트 창입니다.");

                Toast toastView = new Toast(getApplicationContext());
                toastView.setDuration(Toast.LENGTH_SHORT);
                toastView.setGravity(Gravity.CENTER,0,100);
                toastView.setView(view);
                toastView.show();
            }
        });
    }

//    public void onClick(View v){
//        Snackbar.make(v,"SmackBar로 보여주는 메세지 ",1000).setAction("확인 ", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ///
//            }
//        }).show();
//    }

     public void onClick(View v){
         if(v.getId()==R.id.button5){
             AlertDialog.Builder dlg = new AlertDialog.Builder(this);

             dlg.setTitle("기본 대화 상자")
                     .setIcon(R.mipmap.ic_launcher)
                     .setMessage("이것이 기본 대화 상자입니다 ")
                     .setNegativeButton("닫기 ",null)
                     .setPositiveButton("확인 ",null);//버튼을 눌렀을때 하고 싶으면 null없애고 이벤트 건다

             dlg.show();
         }else if(v.getId()==R.id.button6){
             AlertDialog.Builder dlg = new AlertDialog.Builder(this);

             String data[]={"치킨 ","스파게티 "};
             dlg.setTitle("라디오 대화상자 ")
                     .setSingleChoiceItems(data,1,null)
                     .setIcon(R.mipmap.ic_launcher)
                     .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     });
             dlg.show();

         } else if(v.getId()==R.id.button7){

             final String data[]={"치킨","피자","짜장","탕수육"};
             final boolean checked[]={true,false,false,true};
             AlertDialog.Builder dlg = new AlertDialog.Builder(this);
             dlg.setTitle("체크박스 대화 상자 ")
                     .setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                             checked[which]=isChecked;
                         }
                     });
             dlg.setPositiveButton("선택 완료 ", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     String mes="";
                     for(int i=0;i<checked.length;i++){
                         if(checked[i]){
                             mes = mes+","+data[i];
                         }
                         Toast.makeText(getApplicationContext(),mes.substring(1),Toast.LENGTH_SHORT).show();
                     }
                 }
             });
         }
         else if(v.getId()==R.id.button8){
             View view = View.inflate(this,R.layout.example,null);
             final EditText e1 = (EditText)view.findViewById(R.id.editText);

             AlertDialog.Builder dlg = new AlertDialog.Builder(this);
             dlg.setTitle("사용자 정의 대화 상자 ")
                     .setPositiveButton("확인 ",null)
                     .setView(view);
             dlg.show();
         }

     }
}
