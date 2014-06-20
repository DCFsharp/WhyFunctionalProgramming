
namespace Misc
open System
open System.IO

module Compostion =

    let sizeOfFolder folder =

        // Get all files under the path
        let filesInFolder : string [] =
            Directory.GetFiles(folder, "*.*", SearchOption.AllDirectories)

        // Map those files to their corresponding FileInfo object
        let fileInfos : FileInfo [] = Array.map (fun (file : string) -> new FileInfo(file))
                                                filesInFolder

        // Map those fileInfo objects to the file's size
        let fileSizes : int64 [] = Array.map (fun (info : FileInfo) -> info.Length)
                                             fileInfos

        // Total the file sizes
        let totalSize = Array.sum fileSizes

        // Return the total size of the files
        totalSize

    let sizeOfFolderPiped2 folder =

        let getFiles folder =
            Directory.GetFiles(folder, "*.*", SearchOption.AllDirectories)

        folder
        |> getFiles
        |> Array.map (fun file -> new FileInfo(file))
        |> Array.map (fun info -> info.Length)
        |> Array.sum

    let sizeOfFolderComposed = // Note! no parameters!! why??

        let getFiles folder =
            Directory.GetFiles(folder, "*.*", SearchOption.AllDirectories)

        // The result of this expression is a function that takes
        // one parameter, which will be passed to getFiles and piped
        // through the following functions.
        getFiles
        >> Array.map (fun file -> new FileInfo(file))
        >> Array.map (fun info -> info.Length)
        >> Array.sum