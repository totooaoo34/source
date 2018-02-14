package com.android.tenementclient.fragment;

import java.util.ArrayList;
import java.util.List;

import com.android.tenementclient.R;
import com.android.tenementclient.adapte.GuessMsgAdapte;
import com.android.tenementclient.entity.GuessMsg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @author Administrator ͷ��-Fragment
 * 
 */
public class TopLineFragment extends Fragment {

	ListView lv_top_line;
	View baike_top_view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_baike_topline,
				container, false);

		baike_top_view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_baike_top, null);

		lv_top_line = (ListView) view.findViewById(R.id.lv_top_line);

		lv_top_line.setDividerHeight(0);
		lv_top_line.addHeaderView(baike_top_view);
		lv_top_line.setAdapter(new GuessMsgAdapte(getActivity(), guessMsgs()));
		return view;
	}

	int[] imgs = { R.drawable.topline01, R.drawable.topline02,
			R.drawable.topline03, R.drawable.topline04 };

	String[] title = { "�����־����������ڿ���", "����ί��̨¥����Ҫ����", "��ɳ������������δ��",
			"��ɳ3����������3.31��" };

	String[] content = { "�����־����������ڿ������������Ƿ���΢�����ڲ���...",
			"����ί��̨¥����Ҫ�������Ż�ס�����õع�Ӧ�ṹ...", "��ع��������ߵ�������ɳס�����������������δ����..",
			"��ɳ3����������3.31��,��������151%.." };

	public List<GuessMsg> guessMsgs() {
		List<GuessMsg> list = new ArrayList<GuessMsg>();
		for (int i = 0; i < imgs.length; i++) {
			GuessMsg msg = new GuessMsg();
			msg.setGuessImg(imgs[i]);
			msg.setGuessTitle(title[i]);
			msg.setGuessContent(content[i]);
			list.add(msg);
		}
		return list;
	}

}
