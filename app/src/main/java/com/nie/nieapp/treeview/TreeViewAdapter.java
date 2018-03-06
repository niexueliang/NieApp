package com.nie.nieapp.treeview;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nie.nieapp.R;
import com.nie.nieapp.databinding.TreeviewItemBinding;

import java.util.ArrayList;

/**
 * TreeViewAdapter
 *
 * @author carrey
 */
public class TreeViewAdapter extends RecyclerView.Adapter<TreeViewAdapter.MyViewHolder> implements View.OnClickListener {
//    OnItemClickListener onItemClickListener;
    //用来临时的存储数据 增加和删除节点时使用
    ArrayList<Element> tempElements = new ArrayList<Element>();
    /**
     * 子元素集合
     */
    private ArrayList<Element> elementsData;
    /**
     * 根元素集合
     */
    private ArrayList<Element> elements;
    /**
     * LayoutInflater
     */
    private LayoutInflater inflater;
    /**
     * item的行首缩进基数
     */
    private int indentionBase;

    private boolean isPadding = false;

    private Activity activity;
    RequestOptions requestOptions;

    public TreeViewAdapter(ArrayList<Element> elements, ArrayList<Element> elementsData, LayoutInflater inflater, Activity activity) {
        this.elements = elements;
        this.elementsData = elementsData;
        this.inflater = inflater;
        indentionBase = 50;
        this.activity = activity;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TreeviewItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.treeview_item, parent, false);
        binding.getRoot().setOnClickListener(this);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        handleElement(holder, position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }


    @Override
    public void onClick(View v) {
        onItemClick((int) v.getTag());
    }


    private void handleElement(MyViewHolder holder, final int position) {
        TreeviewItemBinding binding = holder.getBinding();
        holder.binding.getRoot().setTag(position);
        //获取节点数据
        Element element = elements.get(position);
        //将element 通过数据绑定到xml
        binding.setElement(element);
        //获取节点等级
        int level = element.getLevel();
        //控制缩进
        if (isPadding) {
            binding.treeTypeIcon.setPadding(
                    indentionBase * (level + 1),
                    binding.treeTypeIcon.getPaddingTop(),
                    binding.treeTypeIcon.getPaddingRight(),
                    binding.treeTypeIcon.getPaddingBottom());
        }

        //设置treeSwitch节点的icon图标
        if (element.isHasChildren() && !element.isExpanded()) {
            binding.treeSwitch.setImageResource(R.drawable.scan_close);
            //这里要主动设置一下icon可见，因为convertView有可能是重用了"设置了不可见"的view，下同。
            binding.treeSwitch.setVisibility(View.VISIBLE);
        } else if (element.isHasChildren() && element.isExpanded()) {
            binding.treeSwitch.setImageResource(R.drawable.scan_open);
            binding.treeSwitch.setVisibility(View.VISIBLE);
        } else if (!element.isHasChildren()) {
            binding.treeSwitch.setImageResource(R.drawable.scan_close);
            binding.treeSwitch.setVisibility(View.INVISIBLE);
        }

    }


    private void onItemClick(int position) {

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TreeviewItemBinding binding;

        public MyViewHolder(TreeviewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public TreeviewItemBinding getBinding() {
            return binding;
        }

        public void setBinding(TreeviewItemBinding binding) {
            this.binding = binding;
        }

    }


}
