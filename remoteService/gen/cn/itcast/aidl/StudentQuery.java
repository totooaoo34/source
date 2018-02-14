/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\Android\\workspace\\remoteService\\src\\cn\\itcast\\aidl\\StudentQuery.aidl
 */
package cn.itcast.aidl;
//AIDL

public interface StudentQuery extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements cn.itcast.aidl.StudentQuery
{
private static final java.lang.String DESCRIPTOR = "cn.itcast.aidl.StudentQuery";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an cn.itcast.aidl.StudentQuery interface,
 * generating a proxy if needed.
 */
public static cn.itcast.aidl.StudentQuery asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof cn.itcast.aidl.StudentQuery))) {
return ((cn.itcast.aidl.StudentQuery)iin);
}
return new cn.itcast.aidl.StudentQuery.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_queryStudent:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _result = this.queryStudent(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements cn.itcast.aidl.StudentQuery
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public java.lang.String queryStudent(int number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(number);
mRemote.transact(Stub.TRANSACTION_queryStudent, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_queryStudent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public java.lang.String queryStudent(int number) throws android.os.RemoteException;
}
