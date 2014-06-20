using System;
using System.Collections.Generic;

namespace CSMisc
{
	public class ImmutabilityClosure
	{
		public static void LoopFunc ()
		{
			List<Func<int>> actions = new List<Func<int>> ();

			for (int i = 0; i < 5; i++)
				actions.Add (() => i * 2);

			foreach (var action in actions)
				Console.WriteLine (action ());
		}
	}
}

