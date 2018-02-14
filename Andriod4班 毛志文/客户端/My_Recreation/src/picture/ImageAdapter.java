package picture;



import com.zw.my_recreation.News_Activity;
import com.zw.my_recreation.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;


public class ImageAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private static final int[] ids = {R.drawable.a_1,R.drawable.a_2,R.drawable.a_3,R.drawable.a_4};

	public ImageAdapter(Context context) {
		mContext = context;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// ���غܴ��ֵʹ��getView�е�position����������ʵ��ѭ��
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.image_item, null);
		}
		((ImageView) convertView.findViewById(R.id.imgView))
				.setImageResource(ids[position % ids.length]);
		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// ���������������ת����
				// Intent intent = new Intent(mContext,DetailActivity.class);
				// Bundle bundle = new Bundle();
				// bundle.putInt("image_id", ids[position%ids.length]);
				// intent.putExtras(bundle);
				// mContext.startActivity(intent);
				///Toast.makeText(ImageAdapter.this, "ssss", Toast.LENGTH_SHORT).show();
			}
		});
		return convertView;
	}

}
