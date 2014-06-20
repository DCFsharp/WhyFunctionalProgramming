using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Threading.Tasks;

namespace CSMisc
{
	public static class Extensions
	{
		public static T WithRetry<T>(this Func<T> action)
		{
			var result = default(T);
			int retryCount = 0;

			bool succesful = false;
			do
			{
				try
				{
					result = action();
					succesful = true;
				}
				catch (Exception ex)
				{
					retryCount++;
				}
			} while (retryCount < 3 && !succesful);

			return result;
		}
	}   

	public class RetryMethodTest
	{
		public void Execute()
		{
			// retry is an higerh order function because it takes a function is a parametr
			var msft = "http://microsoft.com";
			var client = new WebClient();
			Func<string> download = () => client.DownloadString(msft);
			var @string = download.WithRetry ();

			// what's happend if I have a function that take a parameter ??


		}
	}
}


