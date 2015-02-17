package com.citruspay.sdkui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by salil on 17/2/15.
 */
public class CitrusWalletAdapter extends RecyclerView.Adapter {

    private List<PaymentOption> mListPaymentOptions = null;

    public CitrusWalletAdapter(List<PaymentOption> listPaymentOptions) {
        this.mListPaymentOptions = listPaymentOptions;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(android.R.layout.simple_list_item_1, viewGroup, false);

        return new CitrusWalletViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        if (mListPaymentOptions != null && viewHolder instanceof CitrusWalletViewHolder) {
            PaymentOption option = mListPaymentOptions.get(i);
            ((CitrusWalletViewHolder) viewHolder).txtPaymentOption.setText(option.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (mListPaymentOptions != null) {
            return mListPaymentOptions.size();
        } else {
            return 0;
        }
    }

    public static class CitrusWalletViewHolder extends RecyclerView.ViewHolder {
        protected TextView txtPaymentOption;

        public CitrusWalletViewHolder(View v) {
            super(v);
            txtPaymentOption = (TextView) v.findViewById(android.R.id.text1);
        }
    }
}
