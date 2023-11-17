package com.example.lapmarket.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lapmarket.R;
import com.example.lapmarket.adapter.GioHangAdapter;
import com.example.lapmarket.adapter.SanphamAdapter;
import com.example.lapmarket.dao.GioHangDAO;
import com.example.lapmarket.dao.SanPhamDAO;
import com.example.lapmarket.model.giohang;

import java.util.ArrayList;


public class frg_giohang extends Fragment {

    GioHangDAO gioHangDAO;
    ArrayList<giohang> list;

    GioHangAdapter gioHangAdapter;

    RecyclerView recyclerGH;

    public frg_giohang() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frg_giohang, container, false);


        recyclerGH = view.findViewById(R.id.rec_giohang);

        loadData();
        return view;
    }

    public void loadData(){
        gioHangDAO = new GioHangDAO(getContext());
        list = gioHangDAO.listGH();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerGH.setLayoutManager(linearLayoutManager);

        gioHangAdapter = new GioHangAdapter(getContext(), list, gioHangDAO);
        recyclerGH.setAdapter(gioHangAdapter);
    }
}