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
 * @author Administrator �ٿ�-Fragment
 * 
 */
public class InTradeFragment extends Fragment {

	ListView lv_top_line;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_home, container, false);

		lv_top_line = (ListView) view.findViewById(R.id.lv_home_in);

		lv_top_line.setAdapter(new GuessMsgAdapte(getActivity(), guessMsgs()));
		return view;
	}

	int[] imgs = { R.drawable.intrade01, R.drawable.intrade02,
			R.drawable.intrade03, R.drawable.intrade04 };

	String[] title = { "�ķ��巿�ͼ۴���4600Ԫ��...", "���³�ɳ���⳵���� ��������...",
			"�ͼۺ���ֵ��� ��������Ӯ...", "9���Ż����� 85��or.." };

	String[] content = { "���˼۸񡢻�������ͨ�ȴ������⣬���������ǹ�������ʱҪ����...",
			"��ɳ���⳵���� 2�����𲽼���6Ԫ����8...", "��������ص���ʲô��Ӧ�þ��Ƿ����˰ɣ��Ͼ��������ޣ�����Ǵ��",
			"���˼۸񡢻�������ͨ�ȴ������⣬���������ǹ�������ʱҪ����..." };

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
