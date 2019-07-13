package myapp.dell.example.android.bmscecanteenapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private Context ctx;

    public CustomAdapter(Context ctx) {

        inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
    }

    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.MyViewHolder holder, int position) {

        holder.tvOrder.setText(MainActivity.modelArrayList.get(position).getOrder());
        holder.tvNumber.setText(String.valueOf(MainActivity.modelArrayList.get(position).getNumber()));
        holder.tvQuantity.setText(String.valueOf(MainActivity.modelArrayList.get(position).getTotal()));
        holder.tvPrices.setText(String.valueOf(MainActivity.modelArrayList.get(position).getPrices()));

    }

    @Override
    public int getItemCount() {
        return MainActivity.modelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected Button btn_plus, btn_minus;
        private TextView tvOrder, tvPrices,tvNumber,tvQuantity;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvOrder = (TextView) itemView.findViewById(R.id.animal);
            tvPrices = (TextView) itemView.findViewById(R.id.animal1);
            tvNumber = (TextView) itemView.findViewById(R.id.number);
            tvQuantity = (TextView)itemView.findViewById(R.id.total_price);
            btn_plus = (Button) itemView.findViewById(R.id.plus);
            btn_minus = (Button) itemView.findViewById(R.id.minus);


            btn_plus.setTag(R.integer.btn_plus_view, itemView);
            btn_minus.setTag(R.integer.btn_minus_view, itemView);
            btn_plus.setOnClickListener(this);
            btn_minus.setOnClickListener(this);

        }

        // onClick Listener for view
        @Override
        public void onClick(View v) {

            if (v.getId() == btn_plus.getId()) {

                View tempview = (View) btn_plus.getTag(R.integer.btn_plus_view);
                TextView tv = (TextView) tempview.findViewById(R.id.number);
                int number = Integer.parseInt(tv.getText().toString()) + 1;
                tv.setText(String.valueOf(number));
                MainActivity.modelArrayList.get(getAdapterPosition()).setNumber(number);

                TextView tv1 = (TextView) tempview.findViewById(R.id.total_price);
                //TextView comp_price=(TextView) tempview.findViewById(R.id.comp_price);

                TextView tv2 = (TextView) tempview.findViewById(R.id.animal1);

                int number1 = Integer.parseInt(tv2.getText().toString());
                int val1 = number * 35;
                int val2 = number* 40;
                int val3 = number * 45;
                //int val4 = number * 45;
                int val5 = number * 50;
                int val_total = val1 + val2 + val3 + val5;
                if(number1==35) {
                    tv1.setText("₹"+String.valueOf(val1));

                    MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val1);

                }
                if(number1==40) {
                    tv1.setText("₹"+String.valueOf(val2));

                    MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val2);
                }
                if(number1==45) {
                    tv1.setText("₹"+String.valueOf(val3));

                    MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val3);
                }
                if(number1==50) {
                    tv1.setText("₹"+String.valueOf(val5));

                    MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val5);
                }


                //comp_price.setText("₹"+String.valueOf(val1+val2+val3+val5));


//                int val1 = number * 35;
//                int val2 = number * 40;
//                int val3 = number * 45;
//                int val4 = number * 45;
//                int val5 = number * 50;
                //int val_total = val1 + val2 + val3 + val4 + val5;


//                    tv1.setText(String.valueOf(val1));
//                Toast.makeText(ctx, ""+val1, Toast.LENGTH_SHORT).show();
                //MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val1);





                // tv2.setText(String.valueOf(val2));
                //MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val2);



//                    if (number == 1) {
//
//                        if (i == 0) {
//                            tv1.setText(String.valueOf(val1));
//                            MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val1);
//                        }
//                        if (i == 1) {
//                            tv1.setText(String.valueOf(val2));
//                            MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val2);
//                        }
//                        if (i == 2) {
//                            tv1.setText(String.valueOf(val3));
//                            MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val3);
//                        }
//                        if (i == 3) {
//                            tv1.setText(String.valueOf(val4));
//                            MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val4);
//                        }
//                        if (i == 4) {
//                            tv1.setText(String.valueOf(val5));
//                            MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val5);
//                        }
//
//
//                    }
//
//
//
//                    }

//                    if (MainActivity.modelArrayList.get(i).getNumber() == 1) {


//                        tv1.setText(String.valueOf(val1));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val1);

//                    }
//                    if (MainActivity.modelArrayList.get(i).getNumber() == 2) {
//
//
//                        tv1.setText(String.valueOf(val2));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val2);
//
//
//                    }
//                    if (MainActivity.modelArrayList.get(i).getNumber() == 3) {
//
//
//                        tv1.setText(String.valueOf(val3));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val3);
//
//
//                    }
//                    if (MainActivity.modelArrayList.get(i).getNumber() == 4) {
//
//
//                        tv1.setText(String.valueOf(val4));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val4);
//
//
//                    }
//                    if (MainActivity.modelArrayList.get(i).getNumber() == 5) {
//
//
//                        tv1.setText(String.valueOf(val5));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val5);
//
//
//                    }
                //else{

                //}
//
//
            }

//                     if(MainActivity.modelArrayList.get(i).getNumber() == 0 && MainActivity.modelArrayList.get(j).getNumber()==0) {
//                        tv1.setText(String.valueOf(val1));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val1);
//                     }
//                     else if(MainActivity.modelArrayList.get(i).getNumber() == 1 && MainActivity.modelArrayList.get(j).getNumber()==1) {
//                        tv1.setText(String.valueOf(val2));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val2);
//                     }
//
//
//                     else if(MainActivity.modelArrayList.get(i).getNumber() == 2 && MainActivity.modelArrayList.get(j).getNumber() == 2) {
//                        tv1.setText(String.valueOf(val3));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val3);
//                     }
//
//                     else if(MainActivity.modelArrayList.get(i).getNumber() == 3 && MainActivity.modelArrayList.get(j).getNumber() == 3) {
//                            tv1.setText(String.valueOf(val4));
//                            MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val4);
//                     }
//
//                     else if(MainActivity.modelArrayList.get(i).getNumber() == 4 && MainActivity.modelArrayList.get(j).getNumber() == 4) {
//                            tv1.setText(String.valueOf(val5));
//                            MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val5);
//                     }

//                    if (i == 0 )
//                    {
            //;


//                    }  else if (!(i == 1 && i != 0)) {
//                        tv1.setText(String.valueOf(val2));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val2);
//
//                    }

//                    } if (i== 2) {
//                        tv1.setText(String.valueOf(val3));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val3);
//
////                    }  if (i == 3) {
//                        tv1.setText(String.valueOf(val4));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val4);
//
////                    }  if (i== 4) {
//                        tv1.setText(String.valueOf(val5));
//                        MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val5);

            //}





            else if(v.getId() == btn_minus.getId()) {

                View tempview = (View) btn_minus.getTag(R.integer.btn_minus_view);
                TextView tv = (TextView) tempview.findViewById(R.id.number);
                int number = Integer.parseInt(tv.getText().toString()) - 1;
                tv.setText(String.valueOf(number));
                MainActivity.modelArrayList.get(getAdapterPosition()).setNumber(number);
                TextView tv1 = (TextView) tempview.findViewById(R.id.total_price);
                //TextView comp_price=(TextView) tempview.findViewById(R.id.comp_price);

                TextView tv2 = (TextView) tempview.findViewById(R.id.animal1);

                int number1 = Integer.parseInt(tv2.getText().toString());
                int val1 = number * 35;
                int val2 = number* 40;
                int val3 = number * 45;
                //int val4 = number * 45;
                int val5 = number * 50;
                int val_total = val1 + val2 + val3 + val5;
                if(number1==35) {
                    tv1.setText("₹"+String.valueOf(val1));

                    MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val1);

                }
                if(number1==40) {
                    tv1.setText("₹"+String.valueOf(val2));

                    MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val2);
                }
                if(number1==45) {
                    tv1.setText("₹"+String.valueOf(val3));

                    MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val3);
                }
                if(number1==50) {
                    tv1.setText("₹"+String.valueOf(val5));

                    MainActivity.modelArrayList.get(getAdapterPosition()).setTotal(val5);
                }

            }
        }

    }

        }


