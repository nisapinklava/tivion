package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

@RestrictTo({Scope.LIBRARY_GROUP})
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    @Nullable
    public static File getTempFile(Context context) {
        String prefix = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
        int i = 0;
        while (i < 100) {
            File file = new File(context.getCacheDir(), prefix + i);
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i++;
            } catch (IOException e) {
            }
        }
        return null;
    }

    @Nullable
    @RequiresApi(19)
    private static ByteBuffer mmap(File file) {
        Throwable th;
        try {
            FileInputStream fis = new FileInputStream(file);
            Throwable th2 = null;
            try {
                FileChannel channel = fis.getChannel();
                MappedByteBuffer map = channel.map(MapMode.READ_ONLY, 0, channel.size());
                if (fis == null) {
                    return map;
                }
                if (0 != 0) {
                    try {
                        fis.close();
                        return map;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                        return map;
                    }
                } else {
                    fis.close();
                    return map;
                }
            } catch (Throwable th4) {
                Throwable th5 = th4;
                th = r1;
                th = th5;
            }
            if (fis != null) {
                if (th != null) {
                    try {
                        fis.close();
                    } catch (Throwable th6) {
                        th.addSuppressed(th6);
                    }
                } else {
                    fis.close();
                }
            }
            throw th;
            throw th;
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r10.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        if (r2 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004e, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004f, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0068, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0069, code lost:
        r2.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0071, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r2.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0076, code lost:
        r8.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x000b] */
    @Nullable
    @RequiresApi(19)
    public static ByteBuffer mmap(Context context, CancellationSignal cancellationSignal, Uri uri) {
        Throwable th;
        try {
            ParcelFileDescriptor pfd = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            Throwable th2 = null;
            try {
                FileInputStream fis = new FileInputStream(pfd.getFileDescriptor());
                Throwable th3 = null;
                try {
                    FileChannel channel = fis.getChannel();
                    MappedByteBuffer map = channel.map(MapMode.READ_ONLY, 0, channel.size());
                    if (fis != null) {
                        if (th3 != null) {
                            fis.close();
                        } else {
                            fis.close();
                        }
                    }
                    if (pfd == null) {
                        return map;
                    }
                    if (th2 != null) {
                        try {
                            pfd.close();
                            return map;
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                            return map;
                        }
                    } else {
                        pfd.close();
                        return map;
                    }
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    th = r1;
                    th = th6;
                }
                if (fis != null) {
                    if (th != null) {
                        fis.close();
                    } else {
                        fis.close();
                    }
                }
                throw th;
                throw th;
                throw th;
                if (pfd != null) {
                }
                throw th;
            } catch (Throwable th7) {
                Throwable th8 = th7;
                Throwable th9 = r1;
                th = th8;
            }
        } catch (IOException e) {
            return null;
        }
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer copyToDirectBuffer(Context context, Resources res, int id) {
        ByteBuffer byteBuffer = null;
        File tmpFile = getTempFile(context);
        if (tmpFile != null) {
            try {
                if (copyToFile(tmpFile, res, id)) {
                    byteBuffer = mmap(tmpFile);
                    tmpFile.delete();
                }
            } finally {
                tmpFile.delete();
            }
        }
        return byteBuffer;
    }

    public static boolean copyToFile(File file, InputStream is) {
        FileOutputStream os = null;
        try {
            FileOutputStream os2 = new FileOutputStream(file, false);
            try {
                byte[] buffer = new byte[1024];
                while (true) {
                    int readLen = is.read(buffer);
                    if (readLen != -1) {
                        os2.write(buffer, 0, readLen);
                    } else {
                        closeQuietly(os2);
                        FileOutputStream fileOutputStream = os2;
                        return true;
                    }
                }
            } catch (IOException e) {
                e = e;
                os = os2;
                try {
                    Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());
                    closeQuietly(os);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(os);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                os = os2;
                closeQuietly(os);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());
            closeQuietly(os);
            return false;
        }
    }

    public static boolean copyToFile(File file, Resources res, int id) {
        InputStream is = null;
        try {
            is = res.openRawResource(id);
            return copyToFile(file, is);
        } finally {
            closeQuietly(is);
        }
    }

    public static void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
            }
        }
    }
}
